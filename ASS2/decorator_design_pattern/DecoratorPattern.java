package decorator_design_pattern;

interface Dress
{
	 public void assemble();
}

class BasicDress implements Dress //This decorator will implement the ChristmasTree interface as well as hold the same object. The implemented method from the same interface will simply call the decorate() method from our interface
{
	 @Override
	 public void assemble()
	 {
	    System.out.println("Basic Dress Features");
	 }
}

class DressDecorator implements Dress  // These decorators will extend our abstract TreeDecorator class and will modify its decorate() method according to our requirement:
{
	 protected Dress dress;
	 public DressDecorator(Dress c)
	 {
	    this.dress = c;
	 }
	  
	 @Override
	 public void assemble() 
	 {
	    this.dress.assemble();
	  }
}

class CasualDress extends DressDecorator //casual dress decorating
{
	 public CasualDress(Dress c) 
	 {
	    super(c);
	 }
	  
	 @Override
	 public void assemble() 
	 {
	    super.assemble();
	    System.out.println("Adding Casual Dress Features");
	 }
}


class SportyDress extends DressDecorator //sporty dress decoratong

{
	 public SportyDress(Dress c) 
	 {
	    super(c);
	 }
	  
	 @Override
	 public void assemble() 
	 {
	    super.assemble();
	    System.out.println("Adding Sporty Dress Features");
	 }
}

class FancyDress extends DressDecorator //fancy dress decoratoing
{
	 public FancyDress(Dress c) 
	 {
	    super(c);
	 }
	  
	 @Override
	 public void assemble()
	 {
	    super.assemble();
	    System.out.println("Adding Fancy Dress Features");
	 }
}

public class DecoratorPattern
{
	  public static void main(String[] args) 
	  {
	      Dress sportyDress = new SportyDress(new BasicDress());
	      sportyDress.assemble();
	      System.out.println();
	     
	      Dress fancyDress = new FancyDress(new BasicDress());
	      fancyDress.assemble();
	      System.out.println();
	    
	      Dress casualDress = new CasualDress(new BasicDress());
	      casualDress.assemble();
	      System.out.println();
	    
	      Dress sportyFancyDress = new SportyDress(new FancyDress(new BasicDress()));
	      sportyFancyDress.assemble();
	      System.out.println();
	    
	      Dress casualFancyDress = new CasualDress(new FancyDress(new BasicDress()));
	      casualFancyDress.assemble();
	  }
}