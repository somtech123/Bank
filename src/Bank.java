import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }
    public boolean addBranch(String branchName){
        if (findBranch( branchName ) == null){
            this.branches.add( new Branch( branchName ) );
            return true;
        }
        return false;
    }
    public boolean addCustomer(String branchName, String customerName, double initialTransaction){
        Branch branch = findBranch( branchName );
        if (branch != null){
          return   branch.newCustomer( customerName, initialTransaction );
        }
        return false;
    }
    public boolean addCustomerTransaction(String branchName, String customerName, double transaction){
        Branch branch = findBranch( branchName );
        if (branch != null){
          return   branch.addCustomerTransaction( customerName, transaction );
        }
        return false;
    }
    public boolean listCustomers(String branchName, boolean printTransaction){
        Branch branch = findBranch( branchName );
        if (branch != null){
            System.out.println("Customer details for branch " + branch.getName());

            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (int i=0; i<branchCustomers.size(); i++){
                Customer branchCustomer = branchCustomers.get( i );
                System.out.println("Customer: " + branchCustomer.getName() + "[" + (i+1) +"]");
                if (printTransaction){
                    System.out.println("Transactions");
                    ArrayList<Double> transaction = branchCustomer.getTransactions();
                    for (int j=0; j<transaction.size(); j++){
                        System.out.println("[" + (j+1) + "] amount" + transaction.get( j ));

                    }
                }
            }
            return true;
        } else {
            return false;
        }

    }


    private Branch findBranch(String branchName){
        for (int i=0; i<this.branches.size(); i++){
            Branch CheckedBranch = this.branches.get( i );
            if (CheckedBranch.getName().equals( branchName )){
                return CheckedBranch;
            }
        }
        return null;
    }
}
