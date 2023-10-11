// Abstract Account class representing the common interface for all account types.
abstract class Account 
{
    public abstract float getBalance(); // This method is responsible for getting the account balance.
}

// DepositeAccount class representing a concrete account type.
class DepositeAccount extends Account
{
    private String accountNo;
    private float accountBalance;

    public DepositeAccount(String accountNo, float accountBalance) 
    {
        super();
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    public float getBalance()
    {
        return accountBalance; // Returns the account balance for DepositeAccount.
    }
}

// SavingAccount class representing another concrete account type.
class SavingAccount extends Account 
{
    private String accountNo;
    private float accountBalance;

    public SavingAccount(String accountNo, float accountBalance) 
    {
        super();
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    public float getBalance() 
    {
        return accountBalance; // Returns the account balance for SavingAccount.
    }
}

// CompositeAccount class representing a composite account that can contain multiple accounts.
class CompositeAccount extends Account
{
    private float totalBalance;
    private List<Account> accountList = new ArrayList<Account>();

    public float getBalance() 
    {
        totalBalance = 0;
        for (Account acc : accountList)
        {
            totalBalance = totalBalance + acc.getBalance(); // Calculates the total balance by summing up individual account balances.
        }
        return totalBalance;
    }

    public void addAccount(Account acc) 
    {
        accountList.add(acc); // Adds an account to the composite account.
    }

    public void removeAccount(Account acc) 
    {
        accountList.remove(acc); // Removes an account from the composite account.
    }
}

public class CompositePattern
{
    public static void main(String[] args) 
    {
        CompositeAccount component = new CompositeAccount();

        component.addAccount(new DepositeAccount("DA001", 100));
        component.addAccount(new DepositeAccount("DA002", 150));
        component.addAccount(new SavingAccount("SA001", 200));

        float totalBalance = component.getBalance(); // Gets the total balance for the composite account.
        System.out.println("Total Balance : " + totalBalance);
    }
}
