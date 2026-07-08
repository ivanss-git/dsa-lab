Two Pointers:
Two pointers maintain different indices at different positions in an array or string and move them based on the logic required. 

Pointers could start at opposite direftions and move toward each other until they meet ( pairs, reversing arrays, or palindrome checks), or start at the same location and move in the same direction at different speeds (moving valid elements to one side while skipping duplicates).

Sliding Window:
These questions take a specific sub-category or the same direction-pointer technique while maintaining a contiguous flexible window of elements.

The window length is fixed and slide the windown across the aray by dropping the element leaving the window and adding the element entering it (longest substring without repeating characters).

Summary:
Comparing specific elements or nodes vs evaluating all elements within a contiguous block of memory.

Pointers can move in oppposite waysd vs windows that generally move in the same direction.

Best Time to Buy and Sell:
Since we are trying to implement a sliding window, need to keep time complexity in O(n) and Space in O(1), we need te ignore certain parts of the 



