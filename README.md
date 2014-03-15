JavaDateKit
=======

Date related utitlies for Java, Android
This kit provides builder type date and time operations.

How to use
--------------
There are 2 ways to use this.
1. Copy file to your project.
DateBuilder.java

2. build jar file using ant
Prepared build.xml to make jar file.
Execute ant on this project, you can get datekit.jar in dist folder. 

License
-------
Copyright 2014. [Daiji Ito] [DJ110].
This library is distributed under the terms of the MIT License (MIT)

Example
-------
There are examples in test program(DateBuilderTest.java)

Methods
-------
There are 3 types of 
**Constructor**
- **public DateBuilder()**
Initialize
- ** public DateBuilder( TimeZone zone ) **
Initialize date with TimeZone
- ** public DateBuilder( Date date ) **
Initialize date with date 

**Builder**
Builder part is operation this builder data itself
- ** public DateBuilder on( Date date ) **
Set date
- ** public DateBuilder addDay( int day ) **
Add day date to builder
- ** public DateBuilder subDay( int day ) **
Sub day date to builder
- ** public DateBuilder begin() **
Set time to 00:00:00
- ** public DateBuilder end() **
Set time to end of day 23:59:59
- ** public DateBuilder firstDateOfMonth() **
Set first day of the month
- ** public DateBuilder lastDayOfMonth() **
Set last day of the month
- ** public DateBuilder nextMonthFirst() **
Set first day of the next month
- ** public DateBuilder getFromYMD( int year, int month, int day ) **
Set year, month, day
- ** public DateBuilder getDayofDay( int day ) **
Set week day
- ** public DateBuilder getGMT() **
Set GMT timezone

**Get Data**
Get date, calendar and other parameters
- ** public int getYear() **
Get year
- ** public int getMonth() **
Get month
- ** public int getHour() **
Get hour(24h)
- ** public int getSecond()**
Get second
- ** public Date getTime() **
Get date instance
- ** public Calendar getCal() **
Get calendar instance
- ** public boolean isWeekDay() **
Whether this datebuilder is week day or not
- ** public boolean isWeekEnd() **
Whether this datebuilder is week end or not
- ** public boolean before ( Calendar calendar ) **
Whether this datebuilder is before target calendar or not
- ** public boolean before ( Date date ) **
Whether this datebuilder is before target date or not
- ** public boolean after ( Calendar calendar ) **
Whether this datebuilder is after target calendar or not
- ** public boolean after ( Date date ) **
Whether this datebuilder is after target date or not
- ** public DateBuilder copy() **
Make copy of this instance
** Format **
Return string using format
- ** public String formatYear() **
Return yyyy style
- ** public String formatMonth() **
Return MM style
- ** public String formatDay() **
Return dd style
- ** public String formatA() **
Return yyyy-MM-dd style
- ** public String formatB() **
Return yyyy/MM/dd style
- ** public String formatFull() **
Return yyyy/MM/dd HH:mm:ss style

[DJ110]: http://atmarkplant.com
