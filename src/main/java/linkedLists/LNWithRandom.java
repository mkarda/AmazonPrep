package linkedLists;

class LNWithRandom {
    int val;
    LNWithRandom next;
    LNWithRandom random;

    public LNWithRandom(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public LNWithRandom(int val, LNWithRandom next, LNWithRandom random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}