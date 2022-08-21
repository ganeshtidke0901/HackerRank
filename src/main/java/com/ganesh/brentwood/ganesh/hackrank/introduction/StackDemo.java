package com.ganesh.brentwood.ganesh.hackrank.introduction;


import java.util.Deque;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedDeque;

public class StackDemo {

        public static void main(String []args)
        {
            Scanner sc = new Scanner(System.in);

            while (sc.hasNext()) {
                String input=sc.next();
                if(input.isEmpty()){
                    System.out.println("true");
                    continue;
                }

                Deque<Character> stack=new ConcurrentLinkedDeque<>();
                for (int i=0;i< input.length();i++) {
                    stack.push(input.charAt(i));
                }

                Deque <Character>mirrorStack=new ConcurrentLinkedDeque<>();

                for (Character c : stack) {

                    Optional<Character> optional=Optional.ofNullable(mirrorStack.isEmpty()?null: mirrorStack.peek());

                    char c2=stack.pop();
                    switch(c2)
                    {
                        case '(':
                            if(optional.isPresent() && optional.get().equals(')'))
                            {
                                mirrorStack.pop();
                            }
                            else{
                                mirrorStack.push(c2);
                            }
                            break;
                        case '{':

                            if(optional.isPresent() && optional.get().equals('}'))
                            {
                                mirrorStack.pop();
                            }
                            else{
                                mirrorStack.push(c2);
                            }
                            break;

                        case '[':

                            if(optional.isPresent() && optional.get().equals(']'))
                            {
                                mirrorStack.pop();
                            }
                            else{
                                mirrorStack.push(c2);
                            }
                            break;
                        default:
                            mirrorStack.push(c2);
                            break;


                    }
                }

                if(stack.isEmpty() && mirrorStack.isEmpty())
                {
                    System.out.println("true");
                }else{
                    System.out.println("false");
                }


            }

        }

}
