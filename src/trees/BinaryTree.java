package trees;
public class BinaryTree{
    Node root;
    // * LATEST *//

    public void addNode(int key){
            Node newNode = new Node(key);

            if(root ==null){
                    root = newNode;
            }else{
                    Node focusNode = root;
                    Node parent;

                    while(true){
                            parent = focusNode;
                            if(key <focusNode.key){
                                    focusNode = focusNode.leftChild;
                                    if(focusNode ==null){
                                            parent.leftChild = newNode;
                                            return;
                                    }
                            }else{
                                    focusNode = focusNode.rightChild;
                                    if(focusNode ==null){
                                            parent.rightChild = newNode;
                                            return;
                                    }
                            }
                    }       
            }       
            
    }       
    

    public void inOrderTraversal (Node focusNode){

            if(focusNode !=null){
                    inOrderTraversal(focusNode.leftChild);
                    System.out.println(focusNode.key);
                    inOrderTraversal(focusNode.rightChild);
            }

    }

    
    public void preOrderTraversal (Node focusNode){

        if(focusNode !=null){
                System.out.println(focusNode.key);
                preOrderTraversal(focusNode.leftChild);
                preOrderTraversal(focusNode.rightChild);
        }
}

    public void postOrderTraversal (Node focusNode){

        if(focusNode !=null){

                postOrderTraversal(focusNode.leftChild);
                postOrderTraversal(focusNode.rightChild);
                System.out.println(focusNode.key);
        }
}

    // find a node by key
    public Node findNode(int key){
            Node focusNode = root;

            while(focusNode.key !=key ){
                    if(key < focusNode.key){
                            focusNode = focusNode.leftChild;
                    }else{
                            focusNode = focusNode.rightChild;
                    }

                    if(focusNode ==null){
                            return null;
                    }
            }

            return focusNode;
    }

    public static void main(String[] args){

            BinaryTree theTree = new BinaryTree();

            theTree.addNode(50);
            theTree.addNode(25);
            theTree.addNode(15);
            theTree.addNode(30);
            theTree.addNode(75);
            theTree.addNode(85);

            theTree.postOrderTraversal(theTree.root);

            System.out.println("Search for 30");

            System.out.println(theTree.findNode(30));

    }

}


class Node{
    int key;
    Node leftChild;
    Node rightChild;
    Node(int key){
            this.key = key;
    }

    public  int printNode(){
            return key;
    }
}


    

