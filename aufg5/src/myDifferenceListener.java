import org.custommonkey.xmlunit.DifferenceListener;
import org.custommonkey.xmlunit.Difference;
import org.custommonkey.xmlunit.DifferenceConstants;
import org.w3c.dom.Node;
import java.util.ArrayList;

class myDifferenceListener implements DifferenceListener {
    private static final int[] IGNORE_VALUES = new int[] {
            DifferenceConstants.ATTR_VALUE.getId(),
    };

    private ArrayList<String> attributesRegExes = new ArrayList<String>();

    public myDifferenceListener(){
        super();
        attributesRegExes.add("^transport=\".*\"");
        attributesRegExes.add("^xmlns:apachesoap=\".*\"");
        attributesRegExes.add("^name=\".*\"");
    }

    private boolean isIgnoredDifference(Difference difference) {
        int differenceId = difference.getId();
        for (int i=0; i < IGNORE_VALUES.length; ++i) {
            if (differenceId == IGNORE_VALUES[i]) {
                String controlNode = difference.getControlNodeDetail().getNode().toString();
                int j = 0;
                while(!controlNode.matches(attributesRegExes.get(j)) && j<attributesRegExes.size())
                    j++;
                // if it matched one of the RegExes, difference will be ignores
                return j<attributesRegExes.size();
            }
        }
        return false;
    }

    public int differenceFound(Difference difference) {
        if (isIgnoredDifference(difference)) {
            return RETURN_IGNORE_DIFFERENCE_NODES_IDENTICAL;
        } else {
            return RETURN_ACCEPT_DIFFERENCE;
        }
    }

    public void skippedComparison(Node control, Node test) {
    }
}