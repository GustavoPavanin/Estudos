import prisma from "@prisma/client";

const prismaClient = new prisma.PrismaClient();

async () => {
  try {
    prismaClient.user.create({
      data: {
        name: "Gustavo",
        birthDate: new Date(),
        country: "Brasil",
        region: "SUDESTE",
      },
    });
  } catch (error) {
    console.log(error);
  }
};
