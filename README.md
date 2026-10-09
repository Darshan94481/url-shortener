# URL Shortener

## Run the full stack with Docker Compose

1. Copy .env.example to .env and fill in the database password, JWT secret, and Google OAuth client ID and secret. Keep .env private; it is ignored by Git.
2. In Google Cloud, add http://localhost:8080/login/oauth2/code/google as an authorized redirect URI for the Web OAuth client.
3. From this directory, run docker compose up --build.
4. Open http://localhost:5173. Stop the stack with docker compose down; add -v only if you intend to delete the local database volume.

The Compose file builds this backend from the current checkout and builds the frontend from the main branch of the frontend GitHub repository. The frontend API URL is baked into its static build as http://localhost:8080. Set FRONTEND_URL to the browser-visible frontend origin if you change the published frontend address.

## Build the backend image alone

    docker build -t url-shortener-backend .

The backend expects DB_URL, DB_USERNAME, DB_PASSWORD, JWT_SECRET, FRONTEND_URL, GOOGLE_CLIENT_ID, and GOOGLE_CLIENT_SECRET at runtime.