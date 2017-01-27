# mergingranges

https://www.interviewcake.com/question/java/merging-ranges

Nina from Facebook
networking team
control plane software for network switches


Welcome to Facebook!

This is just a simple shared plaintext pad, with no execution capabilities.

When you know what language you'd like to use for your interview,
simply choose it from the dropdown in the top bar.

Enjoy your interview!

Given an list of intervals, output a sorted list, where all overlapping intervals are merged.

~~~~
[8,9] [3,6] [6,8] [4,5] [1,2] [11,15]
=> [1,2] [3,9] [11,15]

[1,2] [3,6] [4,5] [6,8] [8,9] [11,15]

[1,2] [3,6] [6,8] [8,9] [11,15]

[1,2] [3,8] [8,9] [11,15]

[1,2] [3,9] [11,15]
~~~~

time = O(nlogn)
space = O(1)

~~~~
public class Interval {
  public int min = 0;
  public int max = 0;
  
  public int compareTo(Interval other) {
    return Integer.valueOf(min).compareTo(other.min);
  }
}
  
public class MergeList {
  
  public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
    sort(intervals);
    combine(intervals);
    return intervals;
  }
  
  private void sort(ArrayList<Interval> intervals) {
    intervals.sort();
  }
  
  // [1,2] [3,9] [11,15]
  // i: 3
  // intervals.length: 3
  // min: 11
  // max: 15
  // prevmax: 9
  // 
  private void combine(ArrayList<Interval> intervals) {    
    int i = 1;
    while (i < intervals.length) {
      int min = intervals.get(i).min;
      int max = intervals.get(i).max;
      Interval prev = intervals.get(i-1);
      int prevmax = prev.max;
      if (min <= prevmax) {
        if (max >= prevmax) {
          prev.max = max;
        }
        intervals.remove(i);
      } else {
        i++;
      }
    }
  }
  
}
~~~~