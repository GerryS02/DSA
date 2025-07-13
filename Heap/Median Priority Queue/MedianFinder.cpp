class MedianFinder{
public:
    //max-heap -> store min vales but return max value
    priority_queue<int> left;

    //min-heap -> store max values but return min value
    priority_queue<int, vector<int>, greater<int>> right;

    MedianFinder(){}

    void add(int val){
        if(right.size() > 0 && val > right.top()){
            right.push(val);
        } else{
            left.push(val);
        }

        if(left.size() - right.size() == 2){
            right.push(left.top());
            left.pop();
        } else if(right.size() - left.size() == 2){
            left.push(right.top());
            right.pop();
        }
    }

    double getMedian(){

        if(left.size() > right.size()){
            return left.top();
        } else if(right.size() > left.size()){
            return right.top();
        } else{
            return (left.top() + right.top()) / 2.0;
        }
    }

};