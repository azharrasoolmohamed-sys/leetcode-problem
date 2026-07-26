#include <unordered_map>
#include <string>

using namespace std;

class UndergroundSystem {
private:
    // Map passenger ID -> {Start Station, Check-in Time}
    unordered_map<int, pair<string, int>> checkInMap;
    
    // Map "StartStation->EndStation" -> {Total Travel Time, Total Trips}
    unordered_map<string, pair<double, int>> routeMap;

public:
    UndergroundSystem() {
        
    }
    
    void checkIn(int id, string stationName, int t) {
        checkInMap[id] = {stationName, t};
    }
    
    void checkOut(int id, string stationName, int t) {
        auto checkInInfo = checkInMap[id];
        checkInMap.erase(id); // Clean up checked-out user
        
        string routeKey = checkInInfo.first + "->" + stationName;
        int duration = t - checkInInfo.second;
        
        routeMap[routeKey].first += duration;
        routeMap[routeKey].second += 1;
    }
    
    double getAverageTime(string startStation, string endStation) {
        string routeKey = startStation + "->" + endStation;
        auto& routeData = routeMap[routeKey];
        return routeData.first / routeData.second;
    }
};

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem* obj = new UndergroundSystem();
 * obj->checkIn(id,stationName,t);
 * obj->checkOut(id,stationName,t);
 * double param_3 = obj->getAverageTime(startStation,endStation);
 */
