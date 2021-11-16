/*
Adaptigent Interview Question 5
This program will iterate through a copybook file containing mainframe data structure information, and ensure
that all variable names of structures are no greater than 30 characters. If there exists a variable name greater
than 30 characters, the program will throw an error.
*/

/* We start off by iterating through the file line by line using the .withReader method. We then read the
contents to a string using the readLine method.*/

static checkVarNameLen(String filePath) {
    File file = new File(filePath)
    def line
    file.withReader { reader ->
        while ((line = reader.readLine()) != null) {

            /* Here we split the individual lines into array elements and evaluate the third element. Due to
            the format of the structures on the copybook, we choose the second element because the split will
            occur in this fashion:

            splitLine[0] = "05"
            splitLine[1] = "IDNS" (our variable name)
            splitLine[2] = "CHAR" , etc.

            This way we can isolate the variable name to run through the length comparison.*/

            String[] splitLine = "${line}".split("\\s+")

            //Comparison to see if var length is over limit. If exception thrown, program stops.
            if (splitLine[1].length() > 30)
                throw new Exception("Variable name " + splitLine[1] + " is over 30 characters in length. " +
                        "Stopping program.")
        }
    }

    //If program runs to this point, the test has passed and the method returns.

    println("All variable names are no greater than 30 characters.")
}

checkVarNameLen("C:/Users/Max/Desktop/AdaptigentInterviewq/copybook.txt")




