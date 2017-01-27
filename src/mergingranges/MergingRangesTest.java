package mergingranges;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MergingRangesTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	private Meeting[] convert(int[][] meetings) {
		Meeting[] array = new Meeting[meetings.length];
		for (int i = 0; i < meetings.length; i++) {
			array[i] = new Meeting(meetings[i][0], meetings[i][1]);
		}
		return array;
	}
	
	private void testMergeRange(int[][] expected, int[][] input) {
		Meeting[] expectedMeetings = convert(expected);
		Meeting[] inputMeetings = convert(input);
		Meeting[] ranges = MergingRanges.mergeRanges(inputMeetings);
		assertArrayEquals(expectedMeetings, ranges);
	}
	
	@Test
	public void testMergeRanges1() {
		testMergeRange(new int[][] {{0,1},{3,8},{9,12}}, new int[][] {{0,1},{3,5},{4,8},{10,12},{9,10}});
	}
	
	@Test
	public void testMergeRanges2() {
		testMergeRange(new int[][] {{0,1},{3,8},{9,12}}, new int[][] {{9,10},{10,12},{4,8},{3,5},{0,1}});
	}
	
	@Test
	public void testMergeRanges3() {
		testMergeRange(new int[][] {{1,3}}, new int[][] {{1,2},{2,3}});
	}
	
	@Test
	public void testMergeRanges4() {
		testMergeRange(new int[][] {{1,5}}, new int[][] {{1,5},{2,3}});
	}
	
	@Test
	public void testMergeRanges5() {
		testMergeRange(new int[][] {{1,10}}, new int[][] {{1,10},{2,6},{3,5},{7,9}});
	}
	
}
