# Developer Deployment 1: Local Backend and Local Frontend

In this scenario you will run both the backend and frontend locally on your laptop. Even though we'll be running the backend locally, we need some DynamoDB tables created in AWS so the setup for this involves some remote AWS configuration.

1. Run the Lambda service (aka the backend):
   
    For Deployments 1 and 2, Cognito Domain and S3 Bucket variables do not change.

   - Build the Java code: `sam build`
   - Choose a Cognito Domain matching the pattern `dev-cd-project-buddy-{FULL NAME}` example Cognito Domain: `dev-cd-project-buddy-gabe-guio`
   - Create an S3 bucket: `aws s3 mb s3://dev-b-project-buddy-{FULL NAME}` example Bucket: `dev-b-project-buddy-gabe-guio`
   - Deploy the SAM template:

   ```
   sam deploy --s3-bucket __BUCKET_FROM_ABOVE__ \
   --parameter-overrides S3Bucket=__BUCKET_FROM_ABOVE__ \
   CognitoDomain=__COGNITO_DOMAIN_FROM_ABOVE__ \
   FrontendDeployment=local
   ```

   > **NOTE:** _Yes you have to provide the same S3 bucket name twice._

   **Take note of the "Outputs" produced by the deploy command. You will be using these soon.**

   > **NOTE:** You may find the terminal outputs by visiting the Cloudformation Dashboard > Select "project-buddy-stack" > Outputs

   - Load the sample date provided into the DynamoDB Tables:

   ```
      aws dynamodb batch-write-item --request-items file://data/UserData.json
      aws dynamodb batch-write-item --request-items file://data/ProjectBuddyVersion1Data.json
      aws dynamodb batch-write-item --request-items file://data/ProjectBuddyVersion2Data.json
      aws dynamodb batch-write-item --request-items file://data/StockMarketTrackerData.json
      aws dynamodb batch-write-item --request-items file://data/WebBrowserFightingGameData.json
      aws dynamodb batch-write-item --request-items file://data/BudgetPlanningToolData.json
   ```

   > **TIP:** You only need to do this once.

   1. Run the local API: `sam local start-api --warm-containers LAZY`

2. Configure the frontend application:

   - CD into the web directory: `cd web`
   - Copy the `sample.env.local` file to `.env.local`: `cp sample.env.local .env.local`
   - Open the `.env.local` file in IntelliJ or Visual Studio Code and update the value for these environment variables using the data from the "Ouptuts" of the `sam deploy` in the previous section.

     - `COGNITO_DOMAIN`
     - `COGNITO_USER_POOL_ID`
     - `COGNITO_USER_POOL_CLIENT_ID`

     > **NOTE:** The other environment variables should already have the correct value to run everything locally.

3. Run a local web server (aka the frontend):
   - Make sure you are in the `web` directory.
   - Install dependencies: `npm install`
     > **TIP:** You only need to do this once - _unless_ you add/change Javascript dependencies.
   - Run the local server: `npm run run-local`

After doing all of this, you will have a server running on port `8000` - you can access it by going to [http://localhost:8000](http://localhost:8000) in your browser.

To stop either the local backend (the `sam local...` command) or local frontend (the `npm run...`) command, simply press `Ctrl-C` in the terminal where the process is running.
