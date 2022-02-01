void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
    int p1 = 0;
    int p2 = m;
    std::vector<int> aux(m+n);
    
    for(int i=0; i<m; i++) {
        aux[i] = nums1[i];
    }
    for(int i=0; i<n; i++) {
        aux[i+m] = nums2[i];
    }
    
    for(int i=0; i<(m+n); i++) {
        if(p1 >= m) {   // Out of bounds
            nums1[i] = aux[p2++];
        } else if(p2 >= (m+n)) {   // Out of bounds
            nums1[i] = aux[p1++];
        } else if(aux[p1] < aux[p2]) {
            nums1[i] = aux[p1++];
        } else {
            nums1[i] = aux[p2++];
        }
    }
}
