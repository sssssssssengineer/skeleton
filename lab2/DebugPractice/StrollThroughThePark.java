public class StrollThroughThePark extends Trial {

    /**
     *  The intrepid adventurer Cal Ford is taking a lovely stroll through the jungle looking for treasures.
     *  Help him collect all of the treasures! You may set only one breakpoint
     */
    public static void main(String[] args) {
        /**
         * Set breakpoint at the first line of main, then press F8 to proceed to each next line
         */
        Traveler cal = new Traveler("Jaunty Cal", 3);
        treasureChest(cal);
        treasureChest(cal);
        treasureChest(cal);
        cal.endJourney();
    }

}
