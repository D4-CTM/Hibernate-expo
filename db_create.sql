-- Log in as postgres and paste the next
CREATE USER manager WITH LOGIN PASSWORD 'manager';
CREATE DATABASE gamestop;

ALTER DATABASE gamestop OWNER TO manager;
GRANT ALL PRIVILEGES ON DATABASE gamestop TO manager;

GRANT CONNECT ON DATABASE gamestop TO manager;

-- then connect to 'gamestop' with \c gamestop

CREATE TABLE games (
    id SERIAL PRIMARY KEY,
    game_name VARCHAR(50) NOT NULL,
    game_rating INTEGER DEFAULT 0,
    game_publisher VARCHAR(100)
);