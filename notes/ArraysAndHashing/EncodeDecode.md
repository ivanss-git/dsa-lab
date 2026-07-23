For this problem, we are tasked wtih encoding a list of strings to a string, then decode the encoded string back to the original list. 

My first thought was to use a method to simply conver the list into a string, then back into a list. Simple right? Great intuition but i skipped some very important steps. 

The brute force solution would be to check for empty string, create a list to store the sized of each, append length for each, then build the string by writing sides seperatd by commas -> adding delimtrer -> append all strings in order.

To decode, we check for empty encoded string, read characters from start index to delimeter, then extrcat each substring according to sized list after the delimiter -> read and append. Lastly, return the list of decoded strings. 

The optimal solution would be to directly attach each string to its length, extract characters up to delimeter. This is done by initializing empty result builder, computr length and append string to builder, then return the final encoded string. 

To decode the encoded string, while i is within the bounds of the encoded string, move j up to delimiter, move it o after delimiter, extrct lrngth, append extrcted string to result, then moce i forward by length for next. 