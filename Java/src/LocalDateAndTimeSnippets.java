import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;

import java.time.Duration;
import java.time.Period;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;
import java.time.ZoneId;
import java.time.temporal.ChronoField;

//All material sourced from >>https://www.oracle.com/technetwork/articles/java/jf14-date-time-2125367.html<<
public class LocalDateAndTimeSnippets {
	@Test
	public void testLocalDateInitialization()
	{
		LocalDateTime now = LocalDateTime.now();
		assertThat("LocalDates can be initialized from field values or using 'now'.", 
				now.toLocalDate(),
				is(equalTo(
						LocalDate.of(
								Year.now().getValue(), 
								now.get(ChronoField.MONTH_OF_YEAR),
								now.getDayOfMonth())
				))
		);
	}
	
	@Test
	public void testLocalTimeInitialization()
	{
		assertThat("Local times can be initialized using various 'of' methods.",
				LocalTime.of(17, 18),
				is(equalTo(LocalTime.ofSecondOfDay(17*60*60 + 18*60))));
		//Executive decisions: For now, ignore Clock (which has to be implemented by the user--there are no standard implementations) and
		assertThat("Local times can be parsed from strings.",
				LocalTime.parse("10:15:30"),
				is(equalTo(LocalTime.of(10, 15, 30))));
		
	}
	
	@Test
	public void testLocalDateModification()
	{
		LocalDate now = LocalDate.now();
		LocalDate then = LocalDate.of(1856, 1, 25);
		assertThat("Local dates may be modified using with().",
				now.withMonth(1).withDayOfMonth(1),
				is(equalTo(now.of(Year.now().getValue(), 1, 1))));
		
		LocalDate anAdjustedDate = LocalDate.now();
		LocalDate copyOfThen = LocalDate.of(
				then.get(ChronoField.YEAR),
				then.get(ChronoField.MONTH_OF_YEAR),
				then.get(ChronoField.DAY_OF_MONTH));
		anAdjustedDate = (LocalDate) then.adjustInto(anAdjustedDate);
		assertThat("A given date may be transformed into the value of another "
				+ "LocalDate object using adjustInto().",
				anAdjustedDate,
				is(equalTo(then)));
		assertThat("When adjustInto() is used, the transformer's value is" +
				" not modified.",
				then,
				is(equalTo(copyOfThen)));
		
		LocalDate anotherCopyOfThen = LocalDate.of(
				then.get(ChronoField.YEAR),
				then.get(ChronoField.MONTH_OF_YEAR),
				then.get(ChronoField.DAY_OF_MONTH));
		assertThat("Date periods can have periods added using plus.",
				then.plusDays(2),
				is(equalTo(
						copyOfThen.plus(
								Period.of(0, 0, 2)))));
		assertThat("Addition doesn't modify the original operands (it creates " + 
				"a new LocalDate).",
				then,
				is(equalTo(anotherCopyOfThen)));
		assertThat("Date periods can have periods subtracted.",
				then.minusDays(2),
				is(equalTo(
						copyOfThen.minus(
								Period.of(0, 0, 2)))));
	}

	@Test
	public void testLocalDateComparison()
	{
		LocalDate now = LocalDate.now();
		LocalDate then = LocalDate.of(1856, 1, 25);
		assertThat("Local dates may be compared using isBefore().",
				false,
				is(equalTo(now.isBefore(then))));
		assertThat("Local dates may be compared using isAfter().",
				true,
				is(equalTo(now.isAfter(then))));
		assertThat("Local dates may be compared using isEqual().",
				false,
				is(equalTo(now.isEqual(then))));
		assertThat("Local dates may be compared using compareTo()--" +
				"if the first operand is greater, a positive value returns.",
				true,
				is(equalTo(  now.compareTo(then) > 0  )));
		assertThat("Local dates may be compared using compareTo()--" +
				"if the second operand is greater, a negative value returns.",
				true,
				is(equalTo(  then.compareTo(now) < 0  )));
		assertThat("Local dates may be compared using compareTo()--" +
				"if the operands are equal, 0 returns.",
				true,
				is(equalTo(  then.compareTo(LocalDate.from(then)) == 0  )));
//		/LocalDate.now().comparesTo()
		//now().isAfter(ChronoDateTime), isBefore(), isEqual()
	}
	@Test
	public void testExpansionOfLocalDateToLocalDateTime()
	{
		//LocalDate.now().atStartOfDay()
		//Various now().atTime()
	}
	//LocalDate.now().adjustInto
	/*
	 * 		LocalDate.MAX;
		LocalDate.from(TemporalAccessor t);
		LocalDate.now(Clock clock);
		LocalDate.now(ZoneId zone);
	 */
	
	//Looked up by me
	@Test
	public void testEpochDateConstants()
	{
		LocalDate theUnixEpoch = LocalDate.EPOCH;
		assertThat("The epoch plus 15 days is 1970-01-16.",
				theUnixEpoch.plusDays(15),
				equalTo(LocalDate.of(1970, 1, 16)));
		assertThat("The ofEpochDay method creates a date counted from the epoch.",
				theUnixEpoch.plus(Period.ofDays(15)),
				equalTo(LocalDate.ofEpochDay(15)));
	}
	
	@Test 
	public void testLocalTimeConstants()
	{
		LocalTime noon = LocalTime.NOON;
		assertThat("Local time calculations function similarly to local date " +
				"calculations [but note the use of Duration].",
				noon.plus(Duration.ofHours(12)),
				is(equalTo(LocalTime.MIDNIGHT)));
	}
}
