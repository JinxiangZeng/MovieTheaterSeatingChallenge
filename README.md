# MovieTheaterSeatingChallenge
A Movie Theater Seating Problem program to maximize both customer satisfaction and customer safety.

# Statement

Implement an algorithm for assigning seats within a movie theater to fulfill reservation requests. Assume the movie theater has
the seating arrangement of 10 rows x 20 seats.Design and write a seat assignment program to maximize both customer satisfaction and customer safety.
# Prerequisties

JDK 17 + java access from command prompt

# Steps to compile and execute the program

1) Download source code form Git repository Unzip the file.
2) Open your termina window / command prompt, go to the folder where the unzipped file is saved. And navigate to the folder "src".
3) Run the command to compile the program: javac Main.java
4) Run the command to exceute the programs: java Main.java <Your input file path> 
                                        eg: java Main.java fil/input
5) View result.

# Things to know

# Input file format
 Input file should contains one line of input for each reservation request. The order of the lines in the file reflects the order in
 which the reservation requests were received. Each line in the file will be comprised of a reservation identifier, followed by a space, and then the 
 number of seats requested. The reservation identifier will have the format: R#### \
 eg: \
   R001 2 \
   R002 4 \
   R003 4 \
   R004 3

# Assumptions
1)It assumes that the measure of customer satisfaction is getting a seat in the middle row further and getting all requested seats consecutively. \
2)It assumes that a buffer of one row is required due to public safety. \
3)It assumes the measure of maximum theater utilization is having lesser empty seat in a row. \
4)It assumes that the maximum seats a user can request to reserve cannot be greater than 20. 
