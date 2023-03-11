# Lab №3
**Student:** Liao Xin, M4150 

**Purpose of the work:**

  The purpose of this work is to provide the skills to develop and analyze the evolutionary operators of a genetic algorithm for solving the problem of optimizing a continuous real-valued function.

  As part of the laboratory work, there is a limitation:
    - the domain of the variable : [−5, 5];
    - function range: [0, 10];
    - global optimum: 10;
    - int populationSize < 100;
    - int generations < 10000;

**Описание структуры каталогов:**
```
./
└───lab2-master
    ├───src
    │   └───main
    │       └───java
    │           └───lab2
    └───target
        ├───classes
        │   └───lab2
        └───test-classes
```

## Описание: 

Rewrite the candidateFactory generation function, Crossover function, and Mutation function.

## Описание выполнения:
- Download the original files from [https://gitlab.com/itmo_ec_labs/lab2].
- Rewrite CandidateFactory generation function.
- Rewrite Crossover function.
- Rewrite Mutation function.
- Do some experiment.
- Answer the questions from laboratory.

## CandidateFactory generation function:

   Randomly, create an initial population of candidates.
   
     public double[] generateRandomCandidate(Random random) {
        double[] solution = new double[dimension];
        // x from -5.0 to 5.0
        double min=-5;
        double max = 5;
        for (int i = 0; i < dimension; i++)
        {
            solution[i] = min +(random.nextDouble()*(max-min));
        }
        return solution;
      }
      
 ## Crossover function:
 
 To exchange a segment of a gene from a parent.
 
 ```
 int crossoverIndex = random num;
 offspring1 = parent1[:crossoverIndex] + parent2[crossoverIndex:]
 offspring1 = parent2[:crossoverIndex] + parent1[crossoverIndex:]
 ```
## Mutation function:
  Add the mutationCount of each generation. MutationCount refers to the number of times a gene mutates in each generation，it defaults to populationSize * dimension * 0.8.
  Then population with mutant gens form a new population.
   ```
    for(int i =0;i<mutationCount;i++){
      int mutaIndiv= random.nextInt(population.size());
      int indiv_length= population.get(mutaIndiv).length;
      int mutaIndex = random.nextInt(indiv_length);
      double new_bit = min +(random.nextDouble()*(max-min));
      double[] selected_indiv=population.get(mutaIndiv);
      selected_indiv[mutaIndex] = new_bit;
        }
  ```


## Experiments:
| dimension |	populationSize | Averaged generations | Averaged results | best result |
| ------- |------| ------| ------| ------|
| 2 | 10 |	2777.5 | 9.368 | 9.999 |
| 10 | 10 | 2777.5 | 7.080 | 8.642 |
| 20 | 20 | 2777.5 | 5.952 | 6.664 |
| 50 | 50 | 2777.5 | 5.145 | 5.580 |
| 100 | 100 | 2777.5 | 4.763 | 5.098 |

 As we can see, when the dimension of the problem is 2 (int dimension = 2), the algorithm should easily generate a near-optimal solution in a small number of iterations.


## Answers to questions

1. Что важнее, кроссовер или мутация?
    - Both of them important. The crossover function makes the offspring inherit the good genes from the parents and accelerates the convergence of the objective function. The mutation increases the diversity of genes, thus preventing falling into local optimum.

2. Как влияет значение параметра «размер популяции» на производительность и эффективность алгоритма?
    - The size of the population should neither be too large nor too small. When the population is too small, fewer genes are retained from the parents. But when the population size is too large, the population iteration speed will slow down. Therefore, a population size that is too small or too large will reduce the efficiency of the algorithm.

3. Важно ли знать область определения переменных целевой функции?
    - Knowing the range of the objective function variables helps to set up the stopping condition, so that the algorithm ends more quickly.


