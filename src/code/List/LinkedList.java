package code.List;


public class LinkedList
{
    protected Node startNode;
    protected Node end ;
    public int listSize;

    
    public LinkedList()
    {
        startNode = null;
        end = null;
        listSize = 0;
    }
    
    public int getListSize()
    {
        return listSize;
    }
    
    public void appendAtStart(int val)
    {
        Node nptr = new Node(val, null);
        listSize++ ;
        if(startNode == null)
        {
            startNode = nptr;
            end = startNode;
        }
        else
        {
            nptr.setLink(startNode);
            startNode = nptr;
        }
    }
    public void appendAtEnd(int val)
    {
        Node nptr = new Node(val,null);
        listSize++ ;
        if(startNode == null)
        {
            startNode = nptr;
            end = startNode;
        }
        else
        {
            end.setLink(nptr);
            end = nptr;
        }
    }
    /*  Function to insert an element at position  */
    public void appendAtPos(int val , int pos)
    {
        Node nptr = new Node(val, null);
        Node ptr = startNode;
        pos = pos - 1 ;
        for (int i = 1; i < listSize; i++)
        {
            if (i == pos)
            {
                Node tmp = ptr.getLink() ;
                ptr.setLink(nptr);
                nptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        listSize++ ;
    }
    /*  Method to delete an element at position  */
    public void removeTail()
    {
        if (listSize == 1)
        {
            startNode = null;
            listSize = 0;
            end =null;
            return ;
        }
        else
        {
            Node s = startNode;
            Node t = startNode;
            while (s != end)
            {
                t = s;
                s = s.getLink();
            }
            end = t;
            end.setLink(null);
            listSize--;
            return;
        }

    }

    /*Method to remove greater elements*/
    public void removeGreater(int target)
    {
        if (listSize == 1)
        {
            if(startNode.getData() > target)
            {
                startNode = null;
                listSize = 0;
                end =null;
            }
        }
        else
        {
            Node ptr = startNode;
            int initialSize= listSize;
            for(int count=1;count<=initialSize;count++)
            {
                if(ptr.getData()>target)
                {
                    if(ptr == startNode)
                    {
                        Node tmp = startNode.getLink();
                        startNode = null;
                        startNode = tmp;
                        listSize--;
                    }
                    else if (ptr == end)
                    {
                        removeTail();
                    }
                    else
                    {
                        Node s = startNode;
                        Node t = startNode;

                        while(s != end)
                        {
                            if(s == ptr)
                            {
                                break;
                            }
                            else
                            {
                                t = s;
                                s = s.getLink();
                            }
                        }

                        t.setLink(s.getLink());
                        s = null;
                        listSize--;

                    }
                }
                ptr= ptr.getLink();
            }
        }
    }

    /*  Method to display elements  */
    public void display()
    {
        System.out.print("\nCurrent List = ");
        if (listSize == 0)
        {
            System.out.print("empty\n");
            return;
        }
        if (startNode.getLink() == null)
        {
            System.out.println(startNode.getData() );
            return;
        }
        Node ptr = startNode;
        System.out.print(startNode.getData()+ "->");
        ptr = startNode.getLink();
        while (ptr.getLink() != null)
        {
            System.out.print(ptr.getData()+ "->");
            ptr = ptr.getLink();
        }
        System.out.print(ptr.getData()+ "\n");
    }
}
