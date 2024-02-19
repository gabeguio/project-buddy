# Scenario 2: Remote Backend, Local Frontend

In this scenario you will deploy the backend to AWS and run the frontend locally on your computer. The instructions appear identical to Scenario 1, the main difference is that the web client executes a `.env.remote`  file and not a `.env.local` file.

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

2. Configure the frontend application:
   - CD into the web directory: `cd web`
   - Copy the `sample.env.remote` file to `.env.remote`: `cp sample.env.remote .env.remote`
   - Open the `.env.remote` file in IntelliJ or Visual Studio Code and update the value for these environment variables using the data from the "Ouptuts" of the `sam deploy` in the previous section.
      - `API_BASE_URL`
      - `COGNITO_DOMAIN`
      - `COGNITO_USER_POOL_ID`
      - `COGNITO_USER_POOL_CLIENT_ID`

3. Run a local web server (aka the frontend):
   - CD into the web directory: `cd web`
   - `npm run run-remote`

After doing all of this, you will have a server running on port `8000` - you can access it by going to [http://localhost:8000](http://localhost:8000) in your browser. The difference from Scenario 1 is that now the Lambda functions are running in AWS. If you open the developer tools in your browser you will see requests being made to a URL like `https://GATEWAY_RESOURCE_ID.execute-api.us-east-2.amazonaws.com/Prod`. Once you have made several requests this should be noticeably faster than running the code locally on your laptop.