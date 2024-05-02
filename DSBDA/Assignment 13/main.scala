val data = sc.testFile("input.txt")
data.collect
val splitdata = data.flatMap(line => line.split(" ")) 
splitdata.collect
val mapdata = splitdata.map(word => (word, 1))
mapdata.collect
val reducedata = mapdata.reduceByKey(_ + _)
reducedata.collect


// val splitdata = data.flatMap(line => line.split(" ")): Here, each line of the data RDD is split into words using the space character as a delimiter.
// The flatMap function is used to flatten the resulting collection of arrays into a single collection of words. 

// val mapdata = splitdata.map(word => (word, 1)): Here, each word in the splitdata RDD is mapped to a tuple containing the word itself and the value 1.

// val reducedata = mapdata.reduceByKey(_ + _): Here, the reduceByKey transformation is used to aggregate the counts of each word.