package mergingranges;

import java.util.ArrayList;

public class MergingRanges {

	public static Meeting[] mergeRanges(Meeting[] meetings) {
		ArrayList<Meeting> ranges = new ArrayList<Meeting>();
		for (Meeting meeting: meetings) {
			boolean overlapFound = false;
			int addIndex = 0;
			int lowestIndex = 0;
			int highestIndex = 0;
			for (Meeting range: ranges) {
				if (meeting.endTime < range.startTime) {
					int index = ranges.indexOf(range);
					if (lowestIndex > index) lowestIndex = index;
					addIndex = lowestIndex;
					continue;
				}
				if ((meeting.startTime < range.startTime) && (meeting.endTime <= range.endTime)) {
					overlapFound = true;
					range.startTime = meeting.startTime;
					continue;
				}
				if ((meeting.startTime <= range.endTime) && (meeting.endTime > range.endTime)) {
					overlapFound = true;
					range.endTime = meeting.endTime;
					continue;
				}
				if (meeting.startTime > range.endTime) {
					int index = ranges.indexOf(range) + 1;
					if (highestIndex < index) highestIndex = index;
					addIndex = highestIndex;
					continue;
				}
				if ((meeting.startTime >= range.startTime) && (meeting.endTime <= range.endTime)) {
					overlapFound = true;
					continue;
				}
			}
			
			if (!overlapFound) {
				ranges.add(addIndex, meeting.clone());
			}
		}
		
		Meeting[] rangesArray  = ranges.toArray(new Meeting[ranges.size()]);
		return rangesArray;
	}
	
}
