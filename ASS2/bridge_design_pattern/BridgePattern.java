abstract class TV 
{
    Remote remote;
    TV(Remote r) 
    {
        this.remote = r;
    }
    abstract void on(); // This method is responsible for turning the TV on.
    abstract void off(); // This method is responsible for turning the TV off.
}

class Sony extends TV
{
    Remote remoteType;
    Sony(Remote r) 
    {
        super(r);
        this.remoteType = r;
    }
  
    public void on()
    {
        System.out.print("Sony TV ON: ");
        remoteType.on(); // Calls the on method of the remote to turn on the Sony TV.
    }
    
    public void off()
    {
        System.out.print("Sony TV OFF: ");
        remoteType.off(); // Calls the off method of the remote to turn off the Sony TV.
    }
}
    
class Philips extends TV 
{
    Remote remoteType;
    Philips(Remote r) 
    {
        super(r);
        this.remoteType = r;
    }
  
    public void on()
    {
        System.out.print("Philips TV ON: ");
        remoteType.on(); // Calls the on method of the remote to turn on the Philips TV.
    }
    
    public off()
    {
        System.out.print("Philips TV OFF: ");
        remoteType.off(); // Calls the off method of the remote to turn off the Philips TV.
    }
}

interface Remote
{
    public void on(); // This method is responsible for turning the remote on.
    public void off(); // This method is responsible for turning the remote off.
}

class OldRemote implements Remote 
{
    @Override
    public void on()  
    {
        System.out.println("ON with Old Remote"); // Implementation of turning the old remote on.
    }

    @Override
    public void off() 
    {
        System.out.println("OFF with Old Remote"); // Implementation of turning the old remote off.
    }
}

class NewRemote implements Remote 
{
    @Override
    public void on() 
    {
        System.out.println("ON with New Remote"); // Implementation of turning the new remote on.
    }

    @Override
    public void off() 
    {
        System.out.println("OFF with New Remote"); // Implementation of turning the new remote off.
    }
}

public class BridgePattern 
{
    public static void main(String[] args) 
    {
        TV sonyOldRemote = new Sony(new OldRemote());
        sonyOldRemote.on(); // Turning on a Sony TV using the old remote.
        sonyOldRemote.off(); // Turning off a Sony TV using the old remote.
        System.out.println();
    
        TV sonyNewRemote = new Sony(new NewRemote());
        sonyNewRemote.on(); // Turning on a Sony TV using the new remote.
        sonyNewRemote.off(); // Turning off a Sony TV using the new remote.
        System.out.println();
    
        TV philipsOldRemote = new Philips(new OldRemote());
        philipsOldRemote.on(); // Turning on a Philips TV using the old remote.
        philipsOldRemote.off(); // Turning off a Philips TV using the old remote.
        System.out.println();
    
        TV philipsNewRemote = new Philips(new NewRemote());
        philipsNewRemote.on(); // Turning on a Philips TV using the new remote.
        philipsNewRemote.off(); // Turning off a Philips TV using the new remote.
    }
}
