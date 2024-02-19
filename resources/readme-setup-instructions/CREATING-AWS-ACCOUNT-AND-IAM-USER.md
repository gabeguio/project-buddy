### AWS Account Creation and IAM User Setup:

1. **Create an AWS Account**: [Create and Activate new AWS Account](https://repost.aws/knowledge-center/create-and-activate-aws-account)

2. **Navigate to Users**: Log into your new AWS account and open the [IAM Dashboard](https://console.aws.amazon.com/iam/), select "Users" from the left navigation pane.

3. **Add User**: Click on the "Create user" button.

4. **Set User Details**:

   1. Enter a username like Project_Buddy for the new IAM user. **DO NOT** check the box to provide user access, and then click "Next"
   2. Click "Attach policies directly", and select all relevant policies.
       <details>
       <summary>List of Policies For Project Buddy</summary>

      - AmazonAPIGatewayAdministrator
      - AmazonCognitoPowerUser
      - AmazonDynamoDBFullAccess
      - AmazonS3FullAccess
      - AWSCloudFormationFullAccess
      - AWSLambda_FullAccess
      - CloudFrontFullAccess
      - CloudWatchFullAccess
      - IAMFullAccess
      - AWS SecretsManagerReadWrite

       </details>

   3. Click "Next", and then "Create user". You have now created a user that only has the permission that you specified in the policies.
   4. Navigate back to the Users list in the IAM dashboard, and click on the user that you just created.
   5. Scroll down to the section labeled "Access keys".
   6. Click the button labeled "Create access key".
   7. Select the first option "Command Line Interface (CLI)", check the box at the bottom that says "I understand...", and click the "Next" button (see below for more discussion on why we're ignoring the recommended alternatives here).
   8. Enter something descriptive to help you remember what you're using this for (e.g. "CLI Deployment"), and click "Create access key".
   9. Click the "Show" link next in the "Secret access key" column.
      > LEAVE THIS BROWSER TAB OPEN - we'll come back to this in the next step.

5. **Apply New Credentials**:

   1. In your terminal, run the command `aws configure`, and use the following values:
      - AWS Access Key ID: copy/paste the "Access key" from the browser tab used above.
      - AWS Secret Access Key: copy/paste the "Secret access key" from the browser tab used above.
      - Default region name: `us-east-2`
      - Default output format: `json`

    At this point the AWS CLI (and therefore SAM) should be configured to use the IAM user you created in your AWS account. You can verify this by running the command `aws sts get-caller-identity`. You should see something like this (the exact output doesn't matter, as long as it doesn't print an error it should be set):
    ```
    {
    "UserId": "A_LONG_STRING",
    "Account": "YOUR_ACCOUNT_ID",
    "Arn": "arn:aws:iam::YOUR_ACCOUNT_ID:user/YOUR_NAME"
    }
    ```

    2. If the terminal output matches your new IAM user credentials, you may now close the browser tab.
