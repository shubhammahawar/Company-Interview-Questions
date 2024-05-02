Given a list of all files and folders, and list of selected files and folder
send selected compressed files or folder as input to CLI(Command Line Interface)
by the following condition

If all files under the folder are selected, then only select that folder, CLI auto-selects all files under that folder
If any file is not selected under that folder then get its path to output
Same for subfolders and files
File and folder name could be any size, not compulsory single char file and folder name
File and Folder separated by '/' character
Samples, Input
val all_files = [
"a/b.txt",
"b/c.txt",
"b/d.txt",
"c/e.txt",
"c/f/a.txt",
"c/f/b.txt"
"c/g.txt",
"d/a/b.txt",
]

val selected_Files = [
"b/c.txt",
"b/d.txt",
"c/e.txt",
"c/f/a.txt",
"c/f/b.txt",
"d/a/b.txt",
]

Output: [
"b", <-- both files under folder 'b' is selected hence choose folder itself
"c/e.txt", <-- file 'e' selected but 'g' is not, hence choose a single file
"c/f" <-- all files under folder 'f' is selected hence chosen folder 'f'
"d" <-- all files and folders selected under 'd' folder
]

T.C =  O(N * D), where N is the number of directories and D is the maximum depth of the directory tree


import java.util.*;
import java.io.*;

 class FileDirectory{

public static void main(String args[]){

String[] allDir = new String[]{"/a/b/t.txt", "/a/b/p.txt", "/a/c","/a/d/y.txt","/a/d/z"};

String[] selectedDir = new String[]{"/a/d/z", "/a/d/y.txt", "/a/b/p.txt"};

String result[] = getSelectedDirectoryPath(allDir, selectedDir);

for(int i=0;i<result.length;i++){
System.out.println(result[i]+" ");
}

}

static class Node{
String value;
HashMap<String, Node>children;
int count;
Node parent;

public Node(String value){
this.value = value;
this.children = new HashMap<String,Node>();
this.count=0;
this.parent = this;
}
}

public static HashSet<Node>dir;

public static String[] getSelectedDirectoryPath(String[]allDir, String[]selectedDir){
int n = allDir.length;
Node root = new Node("");

for(int i=0;i<n;i++)
{
String arr[]=allDir[i].split("/");
Node cur = root;

for(int j=0;j<arr.length;j++){
Node temp;
if(cur.children.containsKey(arr[j])){
temp = cur.children.get(arr[j]);
}
else{
temp = new Node(arr[j]);
}
temp.parent=cur;
cur.children.put(arr[j],temp);
cur=temp;
}
}

int m = selectedDir.length;
dir = new HashSet<>();

for(int i=0;i<m;i++){
String[]arr=selectedDir[i].split("/");
Node cur = root;

for(int j=0;j<arr.length;j++){
Node temp = cur.children.get(arr[j]);
cur=temp;
}

process(cur);
}

String ans[] = new String[dir.size()];
int y=0;

for(Node x: dir){
Stack<String>st = new Stack<>();
st.push(x.value);

while(x.parent!=x){
x= x.parent;
st.push("/");
st.push(x.value);
}

StringBuilder fullStr = new StringBuilder();
while(!st.isEmpty()){
fullStr.append(st.pop());
}

ans[y++] = fullStr.toString();
}

return ans;

}

public static void process(Node cur){
dir.add(cur);

if(cur.parent==cur)
return;

cur.parent.count+=1;


if(cur.parent.count==cur.parent.children.size()){

for(Map.Entry<String,Node>tree:cur.parent.children.entrySet()){
Node temp = tree.getValue();
dir.remove(temp);
}

process(cur.parent);
}
}
}
