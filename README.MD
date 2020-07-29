# Matrix multiplication challenge
## Multi thread matrix multiplication challenge   
---   
### Description   
The objective of this activity is to analyse the performance of a matrix multiplier program using different number of threads and different sizes for the matrix.   

### Implementation   
The two matrix are randomly generated. They have the same amount of lines and columns. The size of the matrixes are specified in the execution of the program through the CLI as the first argument passed. The second argument is the amount of threads.   
The program divides the lines of the matrix by the number of threads and the remain of this operation is added to the last thread.   

### How to run the program   
Simple go to the directory of the jar file and type something like:
`$ java -jar desafioMatrixNoPrint.jar 100 10`   
Where the 100, in this case, represents the size of the matrix and the 10 the amount of threads.   
There are more than one .jar file in this project. In the next session, this will be explained.   

### Directories and files   
In the root directory of this application, there are three directories: desafioConsolidado, desafioMatriz and desafioMatrizNoPrint   

- desafioConsolidado: In this directory is only the .jar of the application and the results of the measures alongside with the report containing the details of the results.   
- desafioMatriz: In this directory is the application with it's source code. This version of the application prints the two matrix and the resultant matrix in the console. This is only recommended for checking if the multplication is OK
- desafioMatrizNoPrint: In this directory is the "no print" version of the application. This means that running this will not result in output in the console. The objective of this one is to use as case test for measuring the performance of the multiplication without other factors (linke de outputs to the console). In this directory is also de source code.   

### Measurements   
To measure the results with precision the [Hyperfine application](https://github.com/sharkdp/hyperfine) was used.
For each test, the size of the matrix was fixed and the numner of the threads was varying from 1 to 10. For each number of threads, the Hyperfine was configured to run 10 warmups and then 10 times measuring the amount of time spent in each run and calculating the standard deviation. The results were exported to .csv files that were after converted in the graphics that are in the .pdf report (in pt-BR).   

### Other stuff   
Feel free to comment, edit the code and improve. Let's share knowledge.
