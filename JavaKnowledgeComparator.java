import java.util.Comparator;

public class JavaKnowledgeComparator implements Comparator<CSCE314Student>{

		public int compare(CSCE314Student student1, CSCE314Student student2) {
			if(student1.getJK() > student2.getJK()) {
				return 1;
			}
			else if(student1.getJK() < student2.getJK()) {
				return -1;
			}
			else {
				return 0;
			}
		}
}
