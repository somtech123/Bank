public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank( "access" );
        bank.addBranch( "lagos" );
        bank.addCustomer( "lagos","dre",20 );
        bank.addCustomer( "lagos","oscar",20 );
        bank.addCustomer( "lagos","dre",12 );
        bank.listCustomers( "lagos", true );
    }
}