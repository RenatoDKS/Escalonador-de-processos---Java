# Process Scheduler Simulator

This project, developed by Renato Silveira and Ronaldo Alves for the Computer Engineering course at the Instituto Federal de Educação, Ciência e Tecnologia do Sul de Minas, is a process scheduler simulator implemented in Java. The objective of the project is to create a simulation that visualizes the execution of various process scheduling algorithms on a single CPU. The system computes both the average waiting time and the average throughput for the algorithms.

## Project Overview

The simulator uses Java Threads to manage the simulation of process scheduling. The following tasks are implemented to aid the functioning of the system:

- **Producer Task**: Creates a `Process` object and inserts it into a process queue.
- **Consumer Task**: Removes a `Process` from the queue and allocates it to the CPU.
- **Clock Task**: Simulates the CPU clock, managing the elapsed execution time of the CPU.

### Scheduling Algorithms Implemented

1. **First Come, First Served (FCFS)**: Processes are scheduled in the order they arrive.
2. **Round Robin (RR)**: Processes are assigned a fixed time slice (quantum) in a cyclic order. The quantum is adjustable based on performance metrics.
3. **Additional Algorithm**:
   - **Shortest Job First (SJF)**
   - **Shortest Remaining Time Next (SRTN)**
   - **Multiple Queues**

## Key Features

- **Graphical Simulation**: Visual representation of the process scheduling.
- **Performance Metrics**: Calculation of average waiting time and throughput for each scheduling algorithm.
- **Concurrency Handling**: Utilizes Java Threads to manage task synchronization and ensure correct operation of the scheduling system.

## Implementation Details

The project includes a graphical user interface to visualize the scheduling process. Threads are used to handle:
- The creation and management of process objects.
- The scheduling and execution of processes.
- The simulation of CPU time through a clock task.

### Synchronization and Concurrency

Proper synchronization is essential for the correct functioning of the simulation. Strategies are implemented to ensure that:
- Processes are added and removed from the queue correctly.
- The CPU scheduling is managed without conflicts.
- The clock task accurately reflects the passage of time.

## Report

A short report (2 to 4 pages) will be provided, detailing:
- Key aspects of the implementation.
- Descriptions of the scheduling algorithms.
- Comparative analysis of the algorithms based on average waiting time and average throughput.

## Notes

- The choice of quantum for the Round Robin algorithm is a design decision that should be based on the performance results observed during execution.
- The implementation of the additional scheduling algorithm will be one among SJF, SRTN, or Multiple Queues.
