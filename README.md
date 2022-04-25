# CS2810 Mini-Project: High-Tech MBTA Statistical Analysis
created by Ariel Shtivelberg and Gavin White



## Project Description
### Task:
Having been contacted by the City of Boston to redesign the MBTA T System, we found it in our hearts 
to tackle this concern with user satisfaction. We needed to be able to computer and evaluate the trends,
values, times, etc. for various observations made of each MBTA line. Whether observations for the 
number of minutes a train was delayed on a given day, or the number of delayed trains that occurred
by the hour, recording our observations allowed for a statistical analysis to be done.


### Computing Poisson's Distribution
Computing this distribution over certain time intervals meant observing the number of delayed cars 
for a specific train, at each hour of the day. Every hour from 5 AM to 11 AM, the busiest hours of
operation for the MBTA, the number of delayed trains were tallied up and recorded in the table used 
in the program. The formatting of the table must be as follows:
![](Pictures/p_table.png)  
In this table, the topmost row stores the line names for the MBTA where there are currently the Orange,
Red, Green, and Blue lines. The line names start in the second column. In the first column, and starting
from the second row, times of the day are listed in one hour intervals following the format "HH-HH"
where the first HH is the start time and the second HH is the end time. Computing Poisson's Distribution
requires the formula:
![](Pictures/unnamed.png)  
Where lambda is the average number of events given our data, _e_ is Euler's number and k is the number
of occurrences. What this Poisson Distribution calculates is the probability that you experience k delays
between the provided start and end times given the data observed. We recommend the MBTA continues collecting
data regarding train delays and information because the Law of Large Numbers states that a probability
is more likely to accurately model reality the more data you have.


### Expected Value & Variance
For computing expected values and variances of wait times, data was recorded in a manner where throughout
one day, several average wait times were recorded for each line and the probability that the wait
was in fact that long. Written out in a table, the format follows:
![](Pictures/ev_table.png)  
In this table, the topmost row stores the line names for the MBTA where there are currently the Orange,
Red, Green, and Blue lines. The line names start in the second column. In the first column, and starting
from the second row, probabilities for a given wait time are listed. Computing the Expected Value and Variance
requires the following formulas:  
![](Pictures/exp.png)  
![](Pictures/var.png)  

### Usage
To run the program, first you need to download the files submitted. Once downloaded, launch your 
terminal, change your current working directory to be wherever all these files are located. One in 
the directory, type "java -jar run/Statistics\ Calculator.jar CSVFiles/test.csv CSVFiles/expected.csv"
and the program will launch.

Using the tool is simple. In the text box, type your input and click the appropriate buttons. The tool
has two tables in use, one for Poisson's Distribution and one for Expected Value/Variance. For Poisson's distribution,
type an input in the format of "HH HH k" where the first HH is the starting time you want to use,
the second HH is the ending time you want to use, and k is the number of occurrences you want to calculate.
For Expected Value and Variance, type any line color (Orange, Red, Blue, Green) where the first letter
is capitalized, and the rest is lower case.

If you desire to use your own tables, assuming they follow the proper format (mentioned earlier) you are
welcome to download the .csv file into the CSVFiles folder of this project. Regardless of where the two
.csv files are downloaded, you would want to launch the program with the command "java -jar run/Statistics\ Calculator.jar arg1 arg2"
where arg1 and arg2 are the paths to the two .csv files. The file given for arg1 MUST be the table modelling Poisson's Distribution
and the file given for arg2 the table modelling Expected Value.


