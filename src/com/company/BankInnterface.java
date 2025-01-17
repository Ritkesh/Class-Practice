package com.company;

interface BankInnterface {
    int limit = 40000;

    void Roi();

    class Sbi implements BankInnterface {
        public void Roi() {
            System.out.println("SBI Bank ROI 11.99.... withdraw Limit" + BankInnterface.limit);
        }
    }

    class Axis implements BankInnterface {
        public void Roi() {
            System.out.println("Axis Bank ROI 9.99.... withdraw Limit" + BankInnterface.limit);
        }
    }


    public static void main(String[] args) {
        Sbi sb = new Sbi();
        sb.Roi();
        Axis ax = new Axis();
        ax.Roi();

        BankInnterface b1 = new Sbi();
        b1.Roi();
        BankInnterface b2 = new Axis();
        b2.Roi();
    }
}

