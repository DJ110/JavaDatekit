package com.atmarkplant.javadatekit;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Datekit for Java and Android
 * @author dj110
 *
 */
public class DateBuilder 
{
	private Calendar cal;
	
	public DateBuilder() 
	{
		this.cal = Calendar.getInstance();
	}
	
	public DateBuilder( TimeZone zone ) 
	{
		this.cal = Calendar.getInstance( zone );
	}
	
	public DateBuilder( Date date ) 
	{
		this();
		this.cal.setTime(date);
	}
	
	public DateBuilder on( Date date ) 
	{
		this.cal.setTime(date);
		return this;
	}
	
	public DateBuilder addDay( int day ) 
	{
		cal.add(Calendar.DAY_OF_MONTH, day);
		return this;
	}
	
	public DateBuilder subDay( int day ) 
	{
		cal.add(Calendar.DAY_OF_MONTH, - day);
		return this;
	}
	
	public DateBuilder begin() 
	{
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return this;
	}
	
	public DateBuilder end() 
	{
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 59);
		return this;
	}
	
	public DateBuilder firstDateOfMonth() 
	{
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return this;
	}
	
	public DateBuilder lastDayOfMonth() 
	{
		cal.add(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return this;
	}
	
	public DateBuilder nextMonthFirst() 
	{
		cal.add(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return this;
	}
	
	public DateBuilder getFromYMD( int year, int month, int day ) 
	{
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DAY_OF_MONTH, day);
		return this;
	}
	
	public DateBuilder getFromTime( int hour, int minutes, int second ) 
	{
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, minutes);
		cal.set(Calendar.SECOND, second);
		cal.set(Calendar.MILLISECOND, 0);
		return this;
	}
	
	public DateBuilder getDayofDay( int day ) 
	{
		cal.set(Calendar.DAY_OF_WEEK, day);
		return this;
	}
	
	public DateBuilder getGMT() 
	{
		cal.setTimeZone(TimeZone.getTimeZone("GMT"));
		return this;
	}
	
	public int getYear() 
	{
		return cal.get(Calendar.YEAR);
	}
	
	public int getMonth() 
	{
		return cal.get(Calendar.MONTH);
	}
	
	public int getDay() 
	{
		return cal.get(Calendar.DAY_OF_MONTH);
	}
	
	public int getHour() {
		return cal.get(Calendar.HOUR_OF_DAY);
	}
	
	public int getMinute() {
		return cal.get(Calendar.MINUTE);
	}
	
	public int getSecond() {
		return cal.get(Calendar.SECOND);
	}
	
	public Date getTime() 
	{
		return cal.getTime();
	}
	
	public Calendar getCal() 
	{
		return cal;
	}
	
	public boolean isWeekDay() 
	{
		int day_of = cal.get(Calendar.DAY_OF_WEEK);
		return day_of != Calendar.SUNDAY && day_of != Calendar.SATURDAY;
	}
	
	public boolean isWeekEnd() {
		return !isWeekDay();
	}
	
	public boolean before ( Calendar calendar ) 
	{
		return cal.getTimeInMillis() < calendar.getTimeInMillis();
	}
	
	public boolean before ( Date date ) 
	{
		return cal.getTimeInMillis() < date.getTime();
	}
	
	public boolean after ( Calendar calendar ) 
	{
		return cal.getTimeInMillis() > calendar.getTimeInMillis();
	}
	
	public boolean after ( Date date ) 
	{
		return cal.getTimeInMillis() > date.getTime();
	}
	
	public DateBuilder copy() 
	{
		return new DateBuilder(cal.getTime());
	}
	
	public String formatYear() 
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy", Locale.getDefault());
		return format.format(cal.getTime());
	}
	
	public String formatMonth() 
	{
		SimpleDateFormat format = new SimpleDateFormat("MM", Locale.getDefault());
		return format.format(cal.getTime());	
	}
	
	public String formatDay() 
	{
		SimpleDateFormat format = new SimpleDateFormat("dd", Locale.getDefault());
		return format.format(cal.getTime());	
	}
	
	public String formatA() 
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
		return format.format(cal.getTime());
	}
	
	public String formatB() 
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
		return format.format(cal.getTime());
	}
	
	public String formatFull() 
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault());
		return format.format(cal.getTime());
	}
}
