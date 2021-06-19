/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class ImplementRand10UsingRand7 {
    public int rand10() {
        int noLesser40 = 41;
        while(noLesser40 >= 40) {
            noLesser40 = (rand7() -1)*7 + rand7() -1;
        }
        return noLesser40% 10 + 1;
    }
}

