 String line = "";
     while((line=br.readLine())!=null&&!line.equals("")){
         st = new StringTokenizer(line);
         while(st.hasMoreTokens()){
            String temp = st.nextToken();
            if(isVowel(temp.charAt(0))){
                out.print(temp+"yay ");
            }else{
                int i=0;
                while(!isVowel(temp.charAt(i))){
                    i++;
                }
                temp = temp.substring(i)+temp.substring(0, i)+"ay ";
                out.print(temp+" ");
            }
         }
        out.print("\n");
     }
