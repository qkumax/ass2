// Abstract TV class that has a reference to a Remote, defining abstract methods for turning the TV on and off.
abstract class TV {
    Remote remote;

    TV(Remote r) {
        this.remote = r;
    }

    abstract void on(); // This method is responsible for turning the TV on.
    abstract void off(); // This method is responsible for turning the TV off.
}

// Sony class that extends TV, connecting it with a specific Remote.
class Sony extends TV {
    Remote remoteType;

    Sony(Remote r) {
        super(r);
        this.remoteType = r;
    }

    public void on() {
        System.out.print("Sony TV ON: ");
        remoteType.on(); // Calls the on method of the remote to turn on the Sony TV.
    }

    public void off() {
        System.out.print("Sony TV OFF: ");
        remoteType.off(); // Calls the off method of the remote to turn off the Sony TV.
    }
}

// Philips class that extends TV, connecting it with a specific Remote.
class Philips extends TV {
    Remote remoteType;

    Philips(Remote r) {
        super(r);
        this.remoteType = r;
    }

    public void on() {
        System.out.print("Philips TV ON: ");
        remoteType.on(); // Calls the on method of the remote to turn on the Philips TV.
    }

    public void off() {
        System.out.print("Philips TV OFF: ");
        remoteType.off(); // Calls the off method of the remote to turn off the Philips TV.
    }
}

// Remote interface defining methods for turning the remote on and off.
interface Remote {
    public void on(); // This method is responsible for turning the remote on.
    public void off(); // This method is responsible for turning the remote off.
}

// OldRemote class implementing the Remote interface.
class OldRemote implements Remote {
    @Override
    public void on() {
        System.out.println("ON with Old Remote"); // Implementation of turning the old remote on.
    }

    @Override
    public void off() {
        System.out.println("OFF with Old Remote"); // Implementation of turning the old remote off.
    }
}

// NewRemote class implementing the Remote interface.
class NewRemote implements Remote {
    @Override
    public void on() {
        System.out.println("ON with New Remote"); // Implementation of turning the new remote on.
    }

    @Override
    public void off() {
        System.out.println("OFF with New Remote"); // Implementation of turning the new remote off.
    }
}

public class BridgePattern {
    public static void main(String[] args) {
        // Creating instances of Sony and Philips TVs with both old and new remotes, demonstrating the Bridge pattern.
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
