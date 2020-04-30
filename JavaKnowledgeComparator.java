/*a. The Java Knowledge Comparator essentially takes the Java Knowledge of Student A and Student B and compares them 
 * returns positive # if greater, negative if lower and 0 if equal. 
b.	Jessica Li 
c.	925008863
d.	jml0400@tamu.edu
*/
import java.util.Comparator;
public class JavaKnowledgeComparator implements Comparator<CSCE314Student>{

		public int compare(CSCE314Student student1, CSCE314Student student2) {
			// JK = Java Knowledge
			if(student1.getJK() > student2.getJK()) {
				return 1;
				//student 1 has higher JK
			}
			else if(student1.getJK() < student2.getJK()) {
				return -1;
				//student 1 is lower JK
			}
			else {
				return 0;
				//students have equal JK
			}
		}
}
