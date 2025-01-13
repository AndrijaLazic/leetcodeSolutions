class AddTwoNumberSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        int carry = 0;
        while(true){
            int sum = (l1 == null ? 0 : l1.val)
                    + (l2 == null ? 0 : l2.val)
                    + carry;

            carry = sum / 10;
            sum = sum % 10;

            ListNode temp = result;
            while(temp != null && temp.next != null){
                temp = temp.next;
            }
            if(temp == null){
                temp = new ListNode(sum);
                result = temp;
            }else{
                temp.next = new ListNode(sum);
            }


            if(l1 != null)
                l1 = l1.next;

            if(l2 != null)
                l2 = l2.next;

            if(l1 == null && l2 == null){
                if(carry != 0){
                    if(temp.next == null)
                        temp.next = new ListNode(carry);
                    else
                        temp.next.next = new ListNode(carry);
                }
                break;
            }

        }
        return  result;
    }
}