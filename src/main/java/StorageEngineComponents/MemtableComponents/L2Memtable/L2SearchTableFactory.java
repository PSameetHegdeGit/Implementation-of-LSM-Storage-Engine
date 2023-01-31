package StorageEngineComponents.MemtableComponents.L2Memtable;

public abstract class L2SearchTableFactory{

    private static L2SearchTable searchTable;

    public static L2SearchTable GetSearchTable(String searchTableType) {
        if (searchTableType != null) {
            switch (searchTableType) {
                case "BST":
                    L2SearchTableFactory.searchTable = new BST();
                    break;
                case "AvlTree":
                    L2SearchTableFactory.searchTable = new AvlTree();
                    break;
                case "RedBlackTree":
                    L2SearchTableFactory.searchTable = new RedBlackTree();
                    break;
            }

        }

        return searchTable;
    }

}
