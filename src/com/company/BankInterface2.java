package com.company;
interface BankInnterface2 {
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
    class TestClient{
        void Info1(Sbi b){
            b.Roi();
        }
        void Info2(Axis b){
            b.Roi();
        }
    }

    public static void main(String[] args) {
        TestClient t1 = new TestClient();
        t1.Info1(new Sbi());
        t1.Info2(new Axis());
    }
}


