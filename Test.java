class Test {
    public static void main(String[] args) {
      ChannelRepository channelRepository = new ChannelRepository();
  
      Iterator itr = channelRepository.getIterator();
      System.out.println("Iterating from the channels : ");
      while (itr.hasNext()) {
        String channelName = (String) itr.next();
        System.out.print(channelName + " -> ");
      }
  
      System.out.println("null");
    }
  }
  
  interface Container {
    public Iterator getIterator();
  }
  
  class ChannelRepository implements Container {
    @Override
    public Iterator getIterator() {
      return new ChannelIterator();
    }
  
    static class ChannelIterator implements Iterator {
      private String[] channels = { "CNN", "ESPN", "BBC", "FOX" };
      private int index = 0;
    
      @Override
      public boolean hasNext() {
        return index < channels.length;
      }
    
      @Override
      public Object next() {
        
        String str = channels[index];
        index += 2;
        return str;
      }
    }
  }
  
  interface Iterator {
    public boolean hasNext();
    public Object next();
  }
  
  // for(Map<Integer, Integer> entry : map.entrySet()) {
  //   entry.getkey(),
  //     entry.getValue();
  // }