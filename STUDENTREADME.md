# Student README file

# SpellChecker
This program doesn't produce any output. It needs a test class to be checked. 
What this method does: 
1)  Hashes Dictionary 
-reads through the dictionary file 
-makes everything lower case (just in case) 
-deletes single letter words (like b,c,d,e,f...z) that separate sections in dictionary
-then hashes every word
2) Checks Spelling 
-reads through a text file 
-makes everything lower case 
-checks if words start/and/or end with symbols that aren't letters or digits 
by calling the checkWord method. (this method returns the normal word if it doesn't need to be stripped)
-if this word is not contained in the hashset, then it is mispelled 
-it gets added to a linked list of mispelled words, which is returned @the end of the for loop 
3) Makes Suggestions 
-gets a list of mispelled words 
-tries inserting every letter of the alphabet at every index 
-if this creates a valid word, then that word is added to the suggestions list
-tries deleting each letter. 
-if this creates a valid word, then that word is added to the suggestions list
-tries swapping all adjacent characters. 
-if this creates a valid word, then that word is added to the suggestions list
-at the end, suggestions list is returned. 
# Problem1 
Instructions for compiling/running: 
On command line type: 
`java Problem1 nameofTest.txt`
for example, for the test file I provided it would be 
`java Problem1 beemovie.txt`
Other than that the code is the same as SpellCheckerTester 
# KBestCounter 
-This program finds the k-largest elements in a set of data by using priority queues 
1) public void count(T x)
-checks if heap is at the size of k yet 
-if not, automatically adds. 
-if there are more elements than k, checks if the element is greater than top element of queue
-worst case is O(log k) time.
2) public List<T> kbest()
-this method returns a list sorted in increasing order of the klargest elements. 
-runs in O(k log k) time. 
-after retrieving the k largest elements, it restores the priority queue to its original state. 
