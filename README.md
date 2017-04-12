# Life_simulation-
Create a class Herbivore and a class Carnivore.
Each herbivore eats Plant to survive and each carnivore eats herbivore. Herbivores and carnivores can move to a location around themselves. The speed of movement of carnivores is faster than herbivores. Animals and plants can live for a certain amount of time and after that they will die. Animals have level of energy and if the energy of an animal is less than a specific amount it will die. Animals can get birth to other animals if they are in a certain range of ages and they have enough energy. If energy of an animal is higher than a certain amount it will not eat anything. Plants grow in random locations at certain times ( e.g. a random number between 3 to 5 clocks).
Create a simulation for above scenario. Inside your simulation you should have a concept of the clock, at each clock certain events happen. 
You have to use all the object-oriented concepts that you learned so far, encapsulation and hierarchy are necessary.
Run your simulation in a loop with a certain number of clocks. At each clock print the earth in a good organized format. Use these characters:
Carnivore:      @
Herbivore:      &
Plant:              *
Free Space:   .
Put one space ' ' between each two characters for readability.
I have attached an example of the simulation that uses a grid of 5 x 5 locations. The simulation runs for 4 cycles. You can see all the steps in the that attachment:
Herbivore moves every two cycles, Carnivore moves every cycle. Plant grows every three cycles. The initial energy of all the animals is 3. Carnivore gets birth after age 4 cycle (It ate a herbivore and got 5 energy points so it has enough energy to get birth to a new animal), the energy of the carnivore drops by three and the new-born animal gets three initial energy. Herbivore starves at the last cycle.
Your simulation should be larger with more iterations (More clocks) and remember to put the right parameters to keep the ecosystems alive. Its a very good idea to start with a small simulation and extend it. Also I expect a more realistic simulation from you; for example in each cycle it should reduce the amount of energy from each creature or the movement of carnivores or herbivores or production of plants should be more realistic so the simulation becomes more smoother and easier to follow.

An acceptable size for simulation starts from 30X30 and acceptable iteration starts from 30.

