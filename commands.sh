# To view 10 first rows in filen and 10 last rows in filen
head -n 10 overlaps.m4
tail -n 10 overlaps.m4

# To copy 10 first row of data file into new file:
# head -n 10 overlaps.m4 > testFile2.txt

# To see if the whole second contig is involved in overlap. If not: write whole line to newFile.txt
# awk '{if ($11-$10!=$12) print $1" "$2" "$6" "$7" "$8" "$10" "$11" "$12}' overlaps.m4 > newFile.txt

# To see if the whole first contig is involved in overlap. If not: write whole line to newFile.txt
# awk '{if ($7-$6!=$8) print $1" "$2" "$6" "$7" "$8" "$10" "$11" "$12}' overlaps.m4 > newFile.txt

# combined (new file only has relevant columns):
awk '{if ($7-$6!=$8 && $11-$10!=$12) print $1" "$2" "$6" "$7" "$8" "$10" "$11" "$12}' overlaps.m4 > dataFile.txt

# Compare number of rows in original data file and new data file:
wc -l overlaps.m4 dataFile.txt

# to get small test files, with only the first two columns:
head -n 20 dataFile.txt | awk '{print $1 " " $2}' > testFile1.txt

tail -n 20 dataFile.txt | awk '{print $1 " " $2}' > testFile2.txt

head -n 100 dataFile.txt | tail -n 20 | awk '{print $1 " " $2}' > testFile3.txt

# To see that all files has 20 rows and 40 words
wc -lw testFile?.txt

# To fix so data file only contains the first two columns
cat dataFile.txt | awk '{print $1 " " $2}' > dataFile.txt
