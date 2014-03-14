package com.atmarkplant.javadatekit.tests;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Assert;
import org.junit.Test;

import com.atmarkplant.javadatekit.DateBuilder;

public class DateBuilderTests 
{
	@Test
	public void testYMD() 
	{
		DateBuilder builder = new DateBuilder();
		builder.getFromYMD(2014, 3, 11);
		Assert.assertEquals("2014-03-11", builder.formatA());
	}
	
	@Test
	public void testDate()
	{
		Date date = new Date();
		DateBuilder builder = new DateBuilder( date );
		DateBuilder builder2 = new DateBuilder();
		builder2.on(date);
		Assert.assertEquals(builder.formatA(), builder2.formatA()); 
	}
	
	@Test
	public void testBegin() 
	{
		DateBuilder builder = new DateBuilder();
		Calendar cal = builder.getFromYMD(2014, 3, 11).begin().getCal();
		Assert.assertEquals(0, cal.get(Calendar.HOUR_OF_DAY));
		Assert.assertEquals(0, cal.get(Calendar.MINUTE));
		Assert.assertEquals(0, cal.get(Calendar.SECOND));
		Assert.assertEquals(0, cal.get(Calendar.MILLISECOND));
		Assert.assertEquals("2014/03/11 00:00:00", builder.formatFull());
	}
	
	@Test
	public void testEnd()
	{
		DateBuilder builder = new DateBuilder();
		Calendar cal = builder.getFromYMD(2014, 3, 11).end().getCal();
		Assert.assertEquals(23, cal.get(Calendar.HOUR_OF_DAY));
		Assert.assertEquals(59, cal.get(Calendar.MINUTE));
		Assert.assertEquals(59, cal.get(Calendar.SECOND));
		Assert.assertEquals(59, cal.get(Calendar.MILLISECOND));
		Assert.assertEquals("2014/03/11 23:59:59", builder.formatFull());
	}
	
	@Test
	public void testAdd()
	{
		DateBuilder builder = new DateBuilder();
		builder.getFromYMD(2014, 3, 11).addDay(2);
		Assert.assertEquals("2014-03-13", builder.formatA());
		Assert.assertEquals("2014/03/13", builder.formatB());
	}
	
	@Test
	public void testSub()
	{
		DateBuilder builder = new DateBuilder();
		builder.getFromYMD(2014, 3, 11).subDay(2);
		Assert.assertEquals("2014-03-09", builder.formatA());
	}
	
	@Test
	public void testFirstDay()
	{
		DateBuilder builder = new DateBuilder();
		builder.getFromYMD(2014, 3, 11).firstDateOfMonth();
		Assert.assertEquals("2014-03-01", builder.formatA());
	}
	
	@Test
	public void testEndDay()
	{
		DateBuilder builder = new DateBuilder();
		builder.getFromYMD(2014, 3, 11).lastDayOfMonth();
		Assert.assertEquals("2014-03-31", builder.formatA());
	}
	
	@Test
	public void testNextMonth()
	{
		DateBuilder builder = new DateBuilder();
		builder.getFromYMD(2014, 3, 11).nextMonthFirst();
		Assert.assertEquals("2014-04-01", builder.formatA());
	}
	
	@Test
	public void testFromTime()
	{
		DateBuilder builder = new DateBuilder();
		Calendar cal = builder.getFromYMD(2014, 3, 11).getFromTime(12, 32, 45).getCal();
		
		Assert.assertEquals(12, builder.getHour());
		Assert.assertEquals(32, builder.getMinute());
		Assert.assertEquals(45, builder.getSecond());
		Assert.assertEquals(12, cal.get(Calendar.HOUR_OF_DAY));
		Assert.assertEquals(32, cal.get(Calendar.MINUTE));
		Assert.assertEquals(45, cal.get(Calendar.SECOND));
	}
	
	@Test
	public void testDayOfDay()
	{
		DateBuilder builder = new DateBuilder();
		builder.getFromYMD(2014, 3, 11).getDayofDay(Calendar.SUNDAY);
		Assert.assertEquals("2014-03-09", builder.formatA());
	}
	
	@Test
	public void testWeek()
	{
		DateBuilder builder = new DateBuilder();
		builder.getFromYMD(2014, 3, 11);
		DateBuilder builder2 = new DateBuilder();
		builder2.getFromYMD(2014, 3, 9);
		
		Assert.assertTrue(builder.isWeekDay());
		Assert.assertFalse(builder.isWeekEnd());
		Assert.assertFalse(builder2.isWeekDay());
		Assert.assertTrue(builder2.isWeekEnd());
	}
	
	@Test
	public void beforeafterTest() 
	{
		DateBuilder builder = new DateBuilder();
		builder.getFromYMD(2014, 3, 10);
		DateBuilder builder2 = new DateBuilder();
		Assert.assertFalse(builder2.before(builder.getCal()));
		Assert.assertTrue(builder.before(builder2.getCal()));
		
		Assert.assertTrue(builder2.after(builder.getCal()));
		Assert.assertFalse(builder.after(builder2.getCal()));
		
	}
	
	@Test
	public void gmtTest()
	{
		DateBuilder builder = new DateBuilder(TimeZone.getTimeZone("GMT"));
		builder.getFromYMD(2014, 3, 3).getFromTime(12, 23, 50);
		int hour = builder.getHour();
		Assert.assertEquals(3, hour);
		//builder.formatFull()  // This is your timezone
	}
}
