import static org.hamcrest.MatcherAssert.assertThat;

import java.time.ZoneId;
import java.time.ZoneOffset;

import org.junit.Test;


public class TimeZoneSnippets {
	/**
	 * From the JavaDocs for ZoneId:
	 * 
	 * A time-zone ID, such as Europe/Paris.
	 * 
	 * A ZoneId is used to identify the rules used to convert between an Instant 
	 * and a LocalDateTime. There are two distinct types of ID:
	 * 
	 * Fixed offsets - a fully resolved offset from UTC/Greenwich, that uses the 
	 * same offset for all local date-times
	 * Geographical regions - an area where a specific set of rules for finding the 
	 * offset from UTC/Greenwich apply
	 * 
	 * Most fixed offsets are represented by ZoneOffset. Calling normalized() on 
	 * any ZoneId will ensure that a fixed offset ID will be represented as a ZoneOffset.
	 *
	 */
	@Test
	public void testTimeZones()
	{
		/**
		 * Time-zone IDs
		 * 
		 * The ID is unique within the system. There are three types of ID.
		 * 
		 * The simplest type of ID is that from ZoneOffset. This consists of 
		 * 'Z' and IDs starting with '+' or '-'.
		 * 
		 * The next type of ID are offset-style IDs with some form of prefix, 
		 * such as 'GMT+2' or 'UTC+01:00'. The recognised prefixes are 
		 * 'UTC', 'GMT' and 'UT'. The offset is the suffix and will be 
		 * normalized during creation. These IDs can be normalized to a 
		 * ZoneOffset using normalized().
		 *
		 * The third type of ID are region-based IDs. A region-based ID must 
		 * be of two or more characters, and not start with 
		 * 'UTC', 'GMT', 'UT' '+' or '-'. Region-based IDs are defined by 
		 * configuration, see ZoneRulesProvider. The configuration 
		 * focuses on providing the lookup from the ID to the underlying 
		 * ZoneRules.
		 *
		 * Time-zone rules are defined by governments and change frequently. 
		 * There are a number of organizations, known here as groups, that 
		 * monitor time-zone changes and collate them. The default group is the 
		 * IANA Time Zone Database (TZDB). Other organizations include IATA 
		 * (the airline industry body) and Microsoft.
		 * Each group defines its own format for the region ID it provides. 
		 * The TZDB group defines IDs such as 'Europe/London' or 
		 * 'America/New_York'. TZDB IDs take precedence over other groups.
		 * 
		 * It is strongly recommended that the group name is included in 
		 * all IDs supplied by groups other than TZDB to avoid 
		 * conflicts. For example, IATA airline time-zone region IDs are 
		 * typically the same as the three letter airport code. However, the 
		 * airport of Utrecht has the code 'UTC', which is obviously a 
		 * conflict. The recommended format for region IDs from groups 
		 * other than TZDB is 'group~region'. Thus if IATA data were defined, 
		 * Utrecht airport would be 'IATA~UTC'.
		 */
		
		//Some basic identities....
		
		//assertThat("The 'Z' mode of creating ZoneIds is the same as ZoneOffset.",
		//		ZoneOffset.ofHours(-5),
		//		is(equalTo(ZoneId.of("-5"))));
		//assertThat("The Z prefix is the same as UTC. ZoneId.of("Z-5");
	}
}
