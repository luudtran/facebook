package mergingranges;

public class Meeting {

    int startTime;
    int endTime;

    public Meeting(int startTime, int endTime) {
        // number of 30 min blocks past 9:00 am
        this.startTime = startTime;
        this.endTime   = endTime;
    }

    public String toString() {
        return String.format("(%d, %d)", startTime, endTime);
    }
    
    public Meeting clone() {
    	Meeting clone = new Meeting(startTime, endTime);
    	return clone;
    }

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Meeting)) return false;
		Meeting mtg = (Meeting)obj;
		if ((mtg.startTime == startTime) && (mtg.endTime == endTime)) return true;
		else return false;
	}

	@Override
	public int hashCode() {
		return (new Integer(startTime)).hashCode() + (new Integer(endTime)).hashCode();
	}
    
}
