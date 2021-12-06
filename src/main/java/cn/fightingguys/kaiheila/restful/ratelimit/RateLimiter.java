package cn.fightingguys.kaiheila.restful.ratelimit;

import cn.fightingguys.kaiheila.restful.RestRoute;

public class RateLimiter {

    public static class Bucket {

        private final RestRoute route;

        public Bucket(RestRoute route) {
            this.route = route;
        }

    }

}
